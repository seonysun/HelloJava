package com.sist;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
/* Retention(저장 기간)
 * - source, class : 컴파일 후에 자동으로 사라짐(거의 사용하지 않음)
 * - runtime : 프로그램 종료시까지 유지(default) */
@Target(METHOD)
/* Targer(구분자)
 * - TYPE : 클래스 구분자
 * - METHOD : 메소드 구분자
 * - CONSTRUCTOR : 생성자 구분자
 * - PARAMETER : 매개변수 구분자
 * - FIELD : 멤버변수 구분자 */
public @interface RequestMapping {
	public String value();
	// @RequestMapping("write.do") => 어노테이션의 값을 찾는 경우에 사용 
	   // value() => 매개변수는 사용이 불가능 
	   // public int value() default 1 
	   // @RequestMapping  ==> 1   @RequestMapping(2)
}
