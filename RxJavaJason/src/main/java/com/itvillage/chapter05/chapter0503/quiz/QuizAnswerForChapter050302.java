package com.itvillage.chapter05.chapter0503.quiz;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * range, filter, flatMap을 이용하여 2에서 9까지의 구구단 중에서 짝수단만 출력하세요.
 */
public class QuizAnswerForChapter050302 {
    public static void main(String[] args) {
        Observable.range(2, 8)
                .filter(number -> number % 2 == 0)
                .flatMap(number -> Observable.range(1, 9)
                        .map(row -> number + "*" + row + "=" + (row * number)))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
