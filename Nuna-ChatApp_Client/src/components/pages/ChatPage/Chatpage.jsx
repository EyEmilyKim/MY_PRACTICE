import React, { useEffect, useState } from "react";
import socket from "../../../server";
import MessageContainer from "../../MessageContainer/MessageContainer"
import InputField from "../../InputField/InputField";
import LeaveButton from "../../LeaveButton/LeaveButton";
import './ChatPage.css'
import { useParams } from "react-router-dom";

const ChatPage = ({ user }) => {
    const { id } = useParams() //url에서 룸id 가져오기
    console.log("ChatPage id", id);

    const [messageList, setMessageList] = useState([]);
    console.log("messageList", messageList);
    const [message, setMessage] = useState("");

    useEffect(() => {
        socket.on("message", (res) => {
            console.log("message", res);
            setMessageList((prevState) => prevState.concat(res));
        });
        socket.emit("joinRoom", id, (res) => {
            if (res && res.ok) {
                console.log("successsfully joined", res)
            }
            else {
                console.log("failed to join", res);
            }
        })

    }, [])

    const sendMessage = (event) => {
        event.preventDefault();
        socket.emit("sendMessage", message, (res) => {
            if (!res.ok) {
                console.log("sendMessage error", res.error);
            }
            setMessage("");
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
                    {messageList.length > 0 ? (<MessageContainer messageList={messageList} user={user} />) : null}
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

export default ChatPage
