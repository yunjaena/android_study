package com.itvillage.section3;

import com.itvillage.common.CarMaker;
import com.itvillage.section03.SampleObservable;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * blockingIterable을 사용한 통지 데이터 테스트 예제
 */
public class BlockingIterableTest {
    // 전체 CarMaker의 요소가 맞는지 모두 테스트한다.
    @Test
    public void getCarMakerIterableTest() {
        // when
        Iterable<CarMaker> iterable = SampleObservable.getCarMakerStream()
                .blockingIterable();

        Iterator<CarMaker> iterator = iterable.iterator();

        // then
        assertThat(iterator.hasNext(), is(true));

        assertThat(iterator.next(), is(CarMaker.CHEVROLET));
        assertThat(iterator.next(), is(CarMaker.HYUNDAE));
        assertThat(iterator.next(), is(CarMaker.SAMSUNG));
        assertThat(iterator.next(), is(CarMaker.SSANGYOUNG));
        assertThat(iterator.next(), is(CarMaker.KIA));

    }
}
