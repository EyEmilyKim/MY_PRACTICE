import { useEffect, useState } from "react";
import "./App.css";
import socket from "./server";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import RoomListPage from "./components/pages/RoomListPage/RoomListPage";
import ChatPage from "./components/pages/ChatPage/Chatpage";
import HomePage from "./components/pages/HomePage/HomePage";

function App() {
  const [user, setUser] = useState(null);
  const [rooms, setRooms] = useState([]);

  useEffect(() => {

    socket.on("rooms", (rooms) => {
      setRooms(rooms);
      console.log("rooms", rooms);
    });
    
  }, []);

  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route exact path="/roomList" element={<RoomListPage rooms={rooms} />} />
        <Route exact path="/room/:id" element={<ChatPage user={user} />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
