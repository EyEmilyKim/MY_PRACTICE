import { useEffect, useState } from "react";
import "./App.css";
import socket from "./server";
import InputField from "./components/InputField/InputField";

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

  return (
    <div>
      <div className="App">
        <InputField
          message={message}
          setMessage={setMessage}
          sendMessage={sendMessage}
        />
      </div>
    </div>
  );
}

export default App;
