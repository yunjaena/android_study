package com.itvillage.section3;

import com.itvillage.common.CarMaker;
import com.itvillage.section03.SampleObservable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * RxJava의 API를 사용하지 않은 Unit Test 예제
 */
public class UnitTestNotByRxJava {
    @Test
    public void getCarMakerSyncTest() {
        List<CarMaker> carMakerList = new ArrayList<>();
        SampleObservable.getCarMakerStream()
                .subscribe(data -> carMakerList.add(data));

        assertThat(carMakerList.size(), is(5));
    }
}
