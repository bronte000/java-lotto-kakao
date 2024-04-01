# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 필요한 도메인

- LottoNumber
- LottoTicket
- LottoTickets
- LottoWinningNumbers
- LottoRank [Enum]
- LottoResult (Rank 리스트)

## 기능 요구사항

### LottoNumber

- [x] 로또 숫자는 1부터 45까지의 숫자이다.

### LottoTicket

- [X] 로또 한 장은 6개의 로또 번호로 이루어져 있다.
- [X] 로또 번호는 중복되지 않는다.
- [X] 로또 숫자는 오름차순으로 정렬되어 있다.
- [X] 로또 한 장의 가격은 1000원이다.

### LottoTickets

- [X] 로또 당첨 번호를 받아서 당첨 결과를 리턴한다

### LottoWinningNumbers

- [X] 6개의 로또 번호와 보너스 번호를 가진다.
- [X] 위 7개의 번호는 중복되지 않는다.

### LottoRank

- [X] 1등: 6개 기본 번호가 일치한다
    - 1등의 상금은 2,000,000,000원이다.
- [X] 2등: 5개 기본 번호가 일치하고 보너스 번호가 일치한다
    - 2등의 상금은 30,000,000원이다.
- [X] 3등: 5개 기본 번호가 일치한다
    - 3등의 상금은 1,500,000원이다.
- [X] 4등: 4개 기본 번호가 일치한다
    - 4등의 상금은 50,000원이다.
- [X] 5등: 3개 기본 번호가 일치한다
    - 5등의 상금은 5,000원이다.
- [X] 꽝: 나머지

### LottoResult

- [X] 당첨 총액을 계산한다.
- [X] 수익률을 계산한다.

### LottoTicketGenerator

- [X] 랜덤 번호로 로또 티켓을 생성한다.

## 로또 수동 기능 요구사항
- [X] 수동으로 생성할 로또 티켓 개수를 받는다
- [X] 수동으로 생성할 로또 번호를 받는다
- [X] 수동으로 받은 로또 번호로 로또 티켓을 생성한다
- [X] 수동으로 생성한 로또 티켓을 로또 티켓 리스트에 추가한다
- [X] 구매 후 출력 멘트를 변경한다
- [X] 입력값에 대한 예외 처리를 추가한다

