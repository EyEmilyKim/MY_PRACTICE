import { Input } from "@mui/base";
import { Button } from "@mui/base/Button";
import { useState } from "react";
import './NewRoom.css';

const NewRoom = ({ user }) => {
  const [newTitle, setNewTitle] = useState("");

  const createRoom = (event) => {
    event.preventDefault();

    setNewTitle("");
  };

  return (
    <div className="newRoom-area">
      <form onSubmit={createRoom} className="newRoom-container">
        <Input
        className="newRoom-input"
          placeholder="Wanna create a new room? Type the title here.."
          value={newTitle}
          onChange={(event) => {
            setNewTitle(event.target.value);
          }}
          multiline={false}
          rows={1}
        />
        <Button
          disabled={newTitle === ""}
          type="submit"
          className="newRoom-button"
        >
          만들기
        </Button>
      </form>
    </div>
  );
};

export default NewRoom;
