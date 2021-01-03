package com.itvillage.section3;

import com.itvillage.section03.Calculator;
import com.itvillage.section03.SampleObservable;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * blockingSubscribe를 사용해 구독 후 소비자의 처리로 인해 부수 작용이 발생한 결과를 테스트하는 예제
 */
public class BlockingSubscribeTest {

    // A 지점의 월간 매출 합계를 부수 작용으로 테스트
    @Test
    public void avgTempOfSeoulTest(){
        Calculator calculator = new Calculator();

        SampleObservable.getSalesOfBranchA()
                .blockingSubscribe(data -> calculator.setSum(data));

        assertThat(calculator.getSum(), is(326_000_000));
    }
}
