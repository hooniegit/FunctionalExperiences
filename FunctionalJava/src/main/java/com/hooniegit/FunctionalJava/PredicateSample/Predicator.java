package com.hooniegit.FunctionalJava.PredicateSample;

import java.util.Objects;

/**
 * java.util.function.Predicate
 */
@FunctionalInterface
public interface Predicator<T> {

   /**
    * 단일 추상 메서드
    * : 입력 값에 대해 '특정 조건'을 평가
    * @param var1
    * @return
    */
   boolean test(T var1);

   /**
    * (함수 합성 지원) 기본 메서드
    * : this 조건과 other 조건의 AND 결합
    * @param other
    * @return
    */
   default Predicator<T> and(Predicator<? super T> other) {
      Objects.requireNonNull(other);
      return (t) -> {
         return this.test(t) && other.test(t);
      };
   }

   /**
    * 기본 메서드
    * : this 조건의 NOT 반환
    * @return
    */
   default Predicator<T> negate() {
      return (t) -> {
         return !this.test(t);
      };
   }

   /**
    * (함수 합성 지원) 기본 메서드
    * : this 조건과 other 조건의 AND 결합
    * @param other
    * @return
    */
   default Predicator<T> or(Predicator<? super T> other) {
      Objects.requireNonNull(other);
      return (t) -> {
         return this.test(t) || other.test(t);
      };
   }

   /**
    * 기본 메서드
    * : targetRef 값과의 입력값 비교
    * @param <T>
    * @param targetRef
    * @return
    */
   static <T> Predicator<T> isEqual(Object targetRef) {
      return null == targetRef ? Objects::isNull : (object) -> {
         return targetRef.equals(object);
      };
   }

   /**
    * (함수 합성 지원) 기본 메서드
    * : 조건의 NOT 
    * @param <T>
    * @param target
    * @return
    */
   static <T> Predicator<T> not(Predicator<? super T> target) {
      Objects.requireNonNull(target);
      return (Predicator<T>) target.negate();
   }

}

