package com.itvillage.chapter05.chapter0502.quiz;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * range, skipLast를 이용하여 1부터 15까지의 숫자중에서 마지막에 발행된 숫자 3개를 제외한 나머지 숫자를 출력하세요.
 */
public class QuizAnswerForChapter050204 {
    public static void main(String[] args) {
        Observable.range(1, 15)
                .skipLast(3)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
