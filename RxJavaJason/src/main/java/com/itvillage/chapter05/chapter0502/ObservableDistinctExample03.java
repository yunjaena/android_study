package com.itvillage.chapter05.chapter0502;

import com.itvillage.common.CarMaker;
import com.itvillage.common.SampleData;
import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import io.reactivex.Observable;

public class ObservableDistinctExample03 {
    public static void main(String[] args) {
        Observable.fromIterable(SampleData.carList)
                .distinct(car -> car.getCarMaker())
                .subscribe(car -> Logger.log(LogType.ON_NEXT, car.getCarName()));
    }
}
