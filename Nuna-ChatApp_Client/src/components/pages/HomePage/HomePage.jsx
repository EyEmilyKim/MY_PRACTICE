import {useState } from 'react';
import LoginModal from '../../LoginModal/LoginModal';
import './HomePage.css';

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
    }

    return (
        <div className="home-body">
            <h1 className='home-title'>뇽챗 HomePage입니다</h1>

            {!isLoggedIn ? (
                <div className='nonLoggedIn-area'>
                    <LoginModal handleLoginSuccess={handleLoginSuccess}/ >
                </div>
            ) : (
                <div className='loggedIn-area'>
                    <p className='welcome-userName'>반갑습니다 {user.name}님~~ !</p>
                    <button onClick={handleLogoutSuccess} className='logout-button'>로그아웃 임시</button>
                </div>
            )}

        </div>
    )

}

export default HomePage;