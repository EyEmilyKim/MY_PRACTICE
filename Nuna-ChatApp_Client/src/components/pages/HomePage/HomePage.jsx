import LoginModal from '../../LoginModal/LoginModal';
import './HomePage.css';

const HomePage = () => {

    return (
        <div className="home-body">
            <h1 className='home-title'>뇽챗 HomePage입니다</h1>

            <LoginModal className="login-area"></LoginModal>

        </div>
    )

}

export default HomePage;