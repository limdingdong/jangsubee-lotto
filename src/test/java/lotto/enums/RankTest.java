package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankTest {

    @Test
    @DisplayName("정보에 맞는 랭킹 1등 찾기")
    void findFirstInfoTest() {
        Rank rank = Rank.findRank(6, false);
        assertAll(() -> assertThat(rank.getAmount()).isEqualTo(2_000_000_000),
                () -> assertThat(rank.name()).isEqualTo("FIRST"));
    }

    @Test
    @DisplayName("정보에 맞는 랭킹 2등 찾기")
    void findSecondInfoTest() {
        Rank rank = Rank.findRank(5, true);
        assertAll(() -> assertThat(rank.getAmount()).isEqualTo(50_000_000),
                () -> assertThat(rank.name()).isEqualTo("SECOND"));
    }

    @Test
    @DisplayName("정보에 맞는 랭킹 3등 찾기")
    void findThirdInfoTest() {
        Rank rank = Rank.findRank(5, false);
        assertAll(() -> assertThat(rank.getAmount()).isEqualTo(1_500_000),
                () -> assertThat(rank.name()).isEqualTo("THIRD"));
    }

    @Test
    @DisplayName("정보에 맞는 랭킹 4등 찾기")
    void findFourthInfoTest() {
        Rank rank = Rank.findRank(4, false);
        assertAll(() -> assertThat(rank.getAmount()).isEqualTo(50_000),
                () -> assertThat(rank.name()).isEqualTo("FOURTH"));
    }

    @Test
    @DisplayName("정보에 맞는 랭킹 5등 찾기")
    void findFifthInfoTest() {
        Rank rank = Rank.findRank(3, false);
        assertAll(() -> assertThat(rank.getAmount()).isEqualTo(5_000),
                () -> assertThat(rank.name()).isEqualTo("FIFTH"));
    }

    @Test
    @DisplayName("정보에 맞는 꽝 찾기")
    void notFindInfoTest() {
        Rank rank = Rank.findRank(0, false);
        assertAll(() -> assertThat(rank.getAmount()).isEqualTo(0),
                () -> assertThat(rank.name()).isEqualTo("NOT_MATCH"));
    }
}
