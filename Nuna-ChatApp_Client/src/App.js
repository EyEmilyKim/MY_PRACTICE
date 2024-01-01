import { useEffect, useState } from "react";
import "./App.css";
import socket from "./server";
import InputField from "./components/InputField/InputField";
import MessageContainer from "./components/MessageContainer/MessageContainer";
import LeaveButton from "./components/LeaveButton/LeaveButton";

function App() {
  const [user, setUser] = useState(null);
  const [message, setMessage] = useState("");
  const [messageList, setMessageList] = useState([]);
  console.log("message List", messageList);

  useEffect(() => {
    socket.on("message", (message) => {
      console.log("message", message);
      setMessageList((prevState) => prevState.concat(message));
    });
    askUserName();
  }, []);

  const askUserName = () => {
    const userName = prompt("당신의 이름을 입력하세요");
    console.log("user name : ", userName);

    socket.emit("login", userName, (res) => {
      console.log("Res : ", res);
      if (res?.ok) {
        setUser(res.data);
      }
    });
  };

  const sendMessage = (event) => {
    event.preventDefault();
    socket.emit("sendMessage", message, (res) => {
      console.log("sendMessage res", res);
    });
  };

  const leaveRoom = (event) => {
    event.preventDefault();
    // console.log("퇴장 버튼 눌림");
    socket.emit("leaveRoom", user, (res) => {
      console.log("leaveRoom res", res);
    });
  };

  return (
    <div>
      <div className="App">
        <div className="upper-container">
          <MessageContainer messageList={messageList} user={user} />
        </div>
        <div className="lower-container">
          <LeaveButton user={user} leaveRoom={leaveRoom} />
          <InputField
            message={message}
            setMessage={setMessage}
            sendMessage={sendMessage}
          />
        </div>
      </div>
    </div>
  );
}

export default App;
