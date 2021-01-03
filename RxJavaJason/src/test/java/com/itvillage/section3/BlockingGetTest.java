package com.itvillage.section3;

import com.itvillage.section03.SampleObservable;
import io.reactivex.Observable;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * blockingGet 을 사용한 통지 데이터 테스트 예제
 */
public class BlockingGetTest {
    @Test
    public void blockingGetEmptyTest() {
        // then
        assertThat(Observable.empty().firstElement().blockingGet(), is(nullValue()));
    }

    // A 지점의 월간 매출 합계 테스트
    @Test
    public void totalSalesOfBranchATest() {
        // when
        int totalSales = SampleObservable.getSalesOfBranchA()
                .reduce((a, b) -> a + b)
                .blockingGet();
        // then
        assertThat(totalSales, is(326_000_000));
    }

    // A, B, C 지점의 연간 매출 합계 테스트
    @Test
    public void salesAllBranchTest() {
        // when
        int totalSales = Observable.zip(
                SampleObservable.getSalesOfBranchA(),
                SampleObservable.getSalesOfBranchB(),
                SampleObservable.getSalesOfBranchC(),
                (a, b, c) -> a + b + c
        )
                .reduce((a, b) -> a + b)
                .blockingGet();

        // then
        assertThat(totalSales, is(992_000_000));

    }
}
