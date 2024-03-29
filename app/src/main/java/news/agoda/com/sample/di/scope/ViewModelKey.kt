package news.agoda.com.sample.di.scope



import androidx.lifecycle.ViewModel
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import dagger.MapKey
import kotlin.reflect.KClass

/**
Created by kiranb on 7/6/19
 */

@Documented
@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(RetentionPolicy.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
