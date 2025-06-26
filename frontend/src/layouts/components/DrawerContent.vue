<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '작가 관리' }" />
        <VerticalNavLink
            :item="{
                title: '',
                to: '/',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 목록 조회',
                to: '/authorLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 상세 정보 조회',
                to: '/authorDetails',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '구독 및 열람 관리' }" />
        <VerticalNavLink
            :item="{
                title: '구독자',
                to: '/subscribers',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독',
                to: '/subscriptions',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '도서 열람 내역',
                to: '/bookReadHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '관리자 구독/포인트/도서 내역 요약',
                to: '/adminSubscriberSummaries',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독 상태 조회',
                to: '/subscriptionStatuses',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 사용 내역',
                to: '/pointUsageHistories',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독 목록',
                to: '/subscriptionLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독 상세 정보',
                to: '/subscriptionDetails',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '서재(도서 목록) 관리' }" />
        <VerticalNavLink
            :item="{
                title: '도서',
                to: '/books',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '도서 상세 정보',
                to: '/bookDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '베스트셀러 도서 목록',
                to: '/bestsellerBookLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '도서 목록',
                to: '/bookLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '구독자 상세 정보',
                to: '/subscriberDetails',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'AI 출간 자동화' }" />
        <VerticalNavLink
            :item="{
                title: 'AI 표지 생성 작업',
                to: '/aiCoverJobs',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'AI 커버 작업 상세',
                to: '/aiCoverJobDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: 'AI 커버 작업 목록',
                to: '/aiCoverJobLists',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '포인트 관리' }" />
        <VerticalNavLink
            :item="{
                title: '포인트 지갑',
                to: '/pointWallets',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 지갑 상세',
                to: '/pointWalletDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 소진 상태',
                to: '/pointExhaustedStatuses',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '포인트 트랜잭션 내역',
                to: '/pointTransactionHistories',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '원고 및 출간 관리' }" />
        <VerticalNavLink
            :item="{
                title: '작가',
                to: '/authors',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '원고',
                to: '/manuscripts',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 요청',
                to: '/publicationRequests',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '작가 통계 조회',
                to: '/authorStatistics',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '원고 상세 정보',
                to: '/manuscriptDetails',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 요청 상태 내역',
                to: '/publicationRequestStatuses',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '원고 목록',
                to: '/manuscriptLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 요청 목록',
                to: '/publicationRequestLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '출간 요청 상세',
                to: '/publicationRequestDetails',
            }"
        />
    </ul>
</template>
