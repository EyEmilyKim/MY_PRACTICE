import { useState } from 'react';
import LoginModal from '../../LoginModal/LoginModal';
import './HomePage.css';
import { useNavigate } from 'react-router';

const HomePage = () => {

    const [isLoggedIn, setIsLoggedIn] = useState(false);
    console.log("isLoggedIn : ", isLoggedIn);
    const [user, setUser] = useState(null);
    console.log("user : ", user);

    const handleLoginSuccess = (user) => {
        setIsLoggedIn(true);
        setUser(user);
    }
    const handleLogoutSuccess = () => {
        setIsLoggedIn(false);
        setUser(null);
    }

    const navigate = useNavigate();

    const moveToRoomList = () => {
        navigate(`/roomList`);
    }
    return (
        <div className="home-body">
            <h1 className='home-title'>뇽챗 HomePage입니다</h1>

            {!isLoggedIn ? (
                <div className='nonLoggedIn-area'>
                    <LoginModal handleLoginSuccess={handleLoginSuccess} />
                </div>
            ) : (
                <div className='loggedIn-area'>
                    <p className='welcome-userName'>반갑습니다 {user.name}님~~ !</p>
                    <div onClick={() => { moveToRoomList(user.name) }} className='toRoomList'>채팅하러 가기</div>
                    <button onClick={handleLogoutSuccess} className='logout-button'>로그아웃 임시</button>
                </div>
            )}

        </div>
    )

}

export default HomePage;