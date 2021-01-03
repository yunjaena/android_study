package com.itvillage.section3;

import com.itvillage.section03.SampleObservable;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * blockingForEach를 사용해 통지된 데이터 저부를 테스트한다.
 */
public class BlockingForEachTest {
    // A 구간의 속도 중에서 110 이상인 속도만 필터링 되었는지 테스트
    @Test
    public void getSpeedOfSectionAForEachTest(){
        SampleObservable.getSpeedOfSectionA()
                .filter(speed -> speed > 110)
                .blockingForEach(speed -> assertThat(speed, greaterThan(110)));
    }
}
