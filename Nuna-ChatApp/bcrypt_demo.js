const bcrypt = require("bcrypt");

const user = {
  id: "bcryptian",
  pw: "",
};

/* 1. bcrypt 이용한 비밀번호 저장 */
const try1 = (cb) => {
  console.log("1 user:", user.id, user.pw);

  const saltRounds = 10; //솔팅 라운드 수
  const plainPassword = "123123"; //사용자 제공 비밀번호

  //비밀번호 해싱하여 저장
  bcrypt.hash(plainPassword, saltRounds, (err, hash) => {
    if (err) {
      console.log("해싱 저장 중 에러 발생");
      return;
    }
    user.pw = hash;
    console.log("2 user:", user.id, user.pw);

    /* 비밀번호 해싱 후에 콜백으로 전달된 try2 실행 */
    if(cb){
      cb();
    }
  });

};

/* 2. 로그인 시 비밀번호 확인 */
const try2 = () => {
  const loginPassword_wrong = "000000"; //틀린 비밀번호
  const loginPassword_correct = "123123"; //맞는 비밀번호

  const hashedPasswordFromDB = user.pw; //DB에 저장된 비밀번호

  //비밀번호 비교 _ 틀린
  bcrypt.compare(loginPassword_wrong, hashedPasswordFromDB, (err, result) => {
    if (err) {
      console.log("2_w 로그인 중 에러 발생");
      return;
    }
    if (result) {
      console.log("2_w 로그인 성공", loginPassword_wrong);
    } else {
      console.log("2_w 로그인 실패", loginPassword_wrong);
    }
  });
  //비밀번호 비교 _ 맞는
  bcrypt.compare(loginPassword_correct, hashedPasswordFromDB, (err, result) => {
    if (err) {
      console.log("2_c 로그인 중 에러 발생");
      return;
    }
    if (result) {
      console.log("2_c 로그인 성공", loginPassword_correct);
    } else {
      console.log("2_c 로그인 실패", loginPassword_correct);
    }
  });
};

const main = () => {
    try1(try2);
};

main();
