package cn.sky.framework.annotation;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;

/**
 * 注解类工厂
 * 
 * @see org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean
 * @author gaofu
 */
public class AnnotationClassFactory {

	protected static final Log logger = LogFactory.getLog(AnnotationClassFactory.class);

	private static final String RESOURCE_PATTERN = "/**/*.class";

	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

	private List<String> annotatedPackages = new LinkedList<String>();

	private List<TypeFilter> typeFilters = new LinkedList<TypeFilter>();

	private Set<Class<?>> annotatedClasses = new HashSet<Class<?>>();

	/**
	 * 构造函数
	 * 
	 * @param packagesToScan
	 *            指定要扫描的包,支持多个包"package.a,package.b"并对每个包都会递归搜索
	 * @param annotationFilter
	 *            指定要扫描的注解
	 */
	@SuppressWarnings("unchecked")
	public AnnotationClassFactory(String[] packagesToScan, Class<? extends Annotation>... annotationFilter) {
		if (packagesToScan != null) {
			for (String packagePath : packagesToScan) {
				this.annotatedPackages.add(packagePath);
			}
		}
		if (annotationFilter != null) {
			for (Class<? extends Annotation> annotation : annotationFilter) {
				typeFilters.add(new AnnotationTypeFilter(annotation, false));
			}
		}
	}

	/**
	 * 构造函数
	 * 
	 * @param packagesToScan
	 *            指定要扫描的包,支持多个包"package.a,package.b"并对每个包都会递归搜索
	 * @param annotations
	 *            指定要扫描的注解
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AnnotationClassFactory(List<String> packagesToScan, List<Class<?>> annotations) {
		if (packagesToScan != null) {
			for (String packagePath : packagesToScan) {
				this.annotatedPackages.add(packagePath);
			}
		}
		if (annotations != null) {
			for (Class clazz : annotations) {
				if (clazz.isAnnotation()) {
					typeFilters.add(new AnnotationTypeFilter(clazz, false));
				}
			}
		}
	}

	/**
	 * 将包含指定注解的class返回
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Set<Class<?>> getAnnotatedClasses() throws IOException, ClassNotFoundException {
		this.annotatedClasses.clear();
		if (!this.annotatedPackages.isEmpty()) {
			for (String pkg : this.annotatedPackages) {
				String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
						+ ClassUtils.convertClassNameToResourcePath(pkg) + RESOURCE_PATTERN;
				Resource[] resources = this.resourcePatternResolver.getResources(pattern);
				MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(this.resourcePatternResolver);
				for (Resource resource : resources) {
					if (resource.isReadable()) {
						MetadataReader reader = readerFactory.getMetadataReader(resource);
						String className = reader.getClassMetadata().getClassName();
						if (matchesEntityTypeFilter(reader, readerFactory)) {
							this.annotatedClasses.add(Class.forName(className));
						}
					}
				}
			}
		}
		// 输出日志
		if (logger.isInfoEnabled()) {
			for (Class<?> clazz : this.annotatedClasses) {
				logger.info(String.format("Found class:%s", clazz.getName()));
			}
		}
		return this.annotatedClasses;
	}

	/**
	 * 检查当前扫描到的类是否包含指定的注解
	 * 
	 * @param reader
	 * @param readerFactory
	 * @return
	 * @throws IOException
	 */
	private boolean matchesEntityTypeFilter(MetadataReader reader, MetadataReaderFactory readerFactory)
			throws IOException {
		if (!this.typeFilters.isEmpty()) {
			for (TypeFilter filter : this.typeFilters) {
				if (filter.match(reader, readerFactory)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 将包含指定注解的class返回
	 * 
	 * @param packagesToScan
	 *            要扫描的包集合
	 * @param annotationsToScan
	 *            要扫描的注解集合
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Set<Class<?>> getAnnotatedClasses(List<String> packagesToScan,
			List<Class<? extends Annotation>> annotationsToScan) throws IOException, ClassNotFoundException {
		if (packagesToScan == null || packagesToScan.isEmpty() || annotationsToScan == null
				|| annotationsToScan.isEmpty()) {
			return null;
		}

		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		List<TypeFilter> typeFilters = new LinkedList<TypeFilter>();
		Set<Class<?>> annotatedClasses = new HashSet<Class<?>>();
		for (Class<? extends Annotation> clazz : annotationsToScan) {
			if (clazz.isAnnotation()) {
				typeFilters.add(new AnnotationTypeFilter(clazz, false));
			}
		}
		for (String pkg : packagesToScan) {
			String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
					+ ClassUtils.convertClassNameToResourcePath(pkg) + RESOURCE_PATTERN;
			Resource[] resources = resourcePatternResolver.getResources(pattern);
			MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
			for (Resource resource : resources) {
				if (resource.isReadable()) {
					MetadataReader reader = readerFactory.getMetadataReader(resource);
					String className = reader.getClassMetadata().getClassName();
					if (matchesEntityTypeFilter(reader, readerFactory, typeFilters)) {
						annotatedClasses.add(Class.forName(className));
					}
				}
			}
		}
		// 输出日志
		if (logger.isInfoEnabled()) {
			for (Class<?> clazz : annotatedClasses) {
				logger.info(String.format("Found class:%s", clazz.getName()));
			}
		}
		return annotatedClasses;
	}

	/**
	 * 检查当前扫描到的类是否包含指定的注解
	 * 
	 * @param reader
	 * @param readerFactory
	 * @return
	 * @throws IOException
	 */
	private static boolean matchesEntityTypeFilter(MetadataReader reader, MetadataReaderFactory readerFactory,
			List<TypeFilter> typeFilters) throws IOException {
		if (!typeFilters.isEmpty()) {
			for (TypeFilter filter : typeFilters) {
				if (filter.match(reader, readerFactory)) {
					return true;
				}
			}
		}
		return false;
	}

}