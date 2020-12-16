package com.itvillage.chapter05.chapter0503;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * flatMap을 두번쨰 유형을 이용한 구구단의 2단 출력 예제
 */
public class ObservableFlatMapExample03 {
    public static void main(String[] args) {
        Observable.range(2, 1)
                .flatMap(num -> Observable.range(1, 9),
                        (sourceData, transformedData) ->
                                sourceData + " x " + transformedData + " = " + sourceData * transformedData
                )
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
