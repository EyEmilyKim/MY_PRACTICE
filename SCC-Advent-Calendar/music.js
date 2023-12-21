// 배경음 실행 관련
document.addEventListener('DOMContentLoaded', function() {
    const soundElement = document.querySelector('.sound');
    const stopElement = document.querySelector('.stop');
    const bgm = document.querySelector('.bgm');
  
    soundElement.addEventListener('click', function() {
      bgm.play();
      // bgm.loop = true; // 반복 재생 설정
    });
  
    stopElement.addEventListener('click', function() {
      bgm.pause();
      bgm.currentTime = 0;
    });
  });