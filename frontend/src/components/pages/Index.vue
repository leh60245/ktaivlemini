<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "",
          link: "/",
      },
      {
          text: "작가 목록 조회",
          link: "/authorLists",
      },
      {
          text: "작가 상세 정보 조회",
          link: "/authorDetails",
      },
      {
          text: "구독자",
          link: "/subscribers",
      },
      {
          text: "구독",
          link: "/subscriptions",
      },
      {
          text: "도서 열람 내역",
          link: "/bookReadHistories",
      },
      {
          text: "관리자 구독/포인트/도서 내역 요약",
          link: "/adminSubscriberSummaries",
      },
      {
          text: "구독 상태 조회",
          link: "/subscriptionStatuses",
      },
      {
          text: "포인트 사용 내역",
          link: "/pointUsageHistories",
      },
      {
          text: "구독 목록",
          link: "/subscriptionLists",
      },
      {
          text: "구독 상세 정보",
          link: "/subscriptionDetails",
      },
      {
          text: "도서",
          link: "/books",
      },
      {
          text: "도서 상세 정보",
          link: "/bookDetails",
      },
      {
          text: "베스트셀러 도서 목록",
          link: "/bestsellerBookLists",
      },
      {
          text: "도서 목록",
          link: "/bookLists",
      },
      {
          text: "구독자 상세 정보",
          link: "/subscriberDetails",
      },
      {
          text: "AI 표지 생성 작업",
          link: "/aiCoverJobs",
      },
      {
          text: "AI 커버 작업 상세",
          link: "/aiCoverJobDetails",
      },
      {
          text: "AI 커버 작업 목록",
          link: "/aiCoverJobLists",
      },
      {
          text: "포인트 지갑",
          link: "/pointWallets",
      },
      {
          text: "포인트 지갑 상세",
          link: "/pointWalletDetails",
      },
      {
          text: "포인트 소진 상태",
          link: "/pointExhaustedStatuses",
      },
      {
          text: "포인트 트랜잭션 내역",
          link: "/pointTransactionHistories",
      },
      {
          text: "작가",
          link: "/authors",
      },
      {
          text: "원고",
          link: "/manuscripts",
      },
      {
          text: "출간 요청",
          link: "/publicationRequests",
      },
      {
          text: "작가 통계 조회",
          link: "/authorStatistics",
      },
      {
          text: "원고 상세 정보",
          link: "/manuscriptDetails",
      },
      {
          text: "출간 요청 상태 내역",
          link: "/publicationRequestStatuses",
      },
      {
          text: "원고 목록",
          link: "/manuscriptLists",
      },
      {
          text: "출간 요청 목록",
          link: "/publicationRequestLists",
      },
      {
          text: "출간 요청 상세",
          link: "/publicationRequestDetails",
      },
    ],
  }),
};
</script>
