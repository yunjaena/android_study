package com.itvillage.chapter05.chapter0506;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class CanNotUserTryCatchExample {
    public static void main(String[] args) {
        try {
            Observable.just(2)
                    .map(num -> num / 0)
                    .subscribe(System.out::print);
        } catch (Exception e) {
            Logger.log(LogType.PRINT, "# 에러 처리가 필요: " + e.getCause());
        }
    }
}
