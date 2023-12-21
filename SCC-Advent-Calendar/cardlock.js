// 도달하지 않은 날짜 카드 오픈 제한(html> day-21~ data-date속성 적용)
const today = new Date(); // 오늘 날짜

document.querySelectorAll('input[type="checkbox"]').forEach(input => {
    const inputDate = new Date(input.getAttribute('data-date'));

    if (inputDate > today) {
        input.addEventListener('click', (event) => {
            event.preventDefault(); // 클릭 이벤트 막기
            console.log("아직 도달하지 않은 날짜로 모든 이벤트를 무효화했습니다.");
            // 또는 원하는 다른 작업 수행
        });
    }
});
