package com.itvillage.chapter05.chapter0503.quiz;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.sun.org.apache.xpath.internal.objects.XNumber;
import io.reactivex.Observable;

/**
 * range, filter, map을 이용하여 1부터 15까지의 숫자 중에 2의 배수만 필터링 한 후,
 * 필터링된 숫자에 제곱한 숫자를 출력하세요.
 */
public class QuizAnswerForChapter050301 {
    public static void main(String[] args) {
        Observable.range(1, 15)
                .filter(number -> number % 2 == 0)
                .map(number -> Math.pow(number , 2))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
