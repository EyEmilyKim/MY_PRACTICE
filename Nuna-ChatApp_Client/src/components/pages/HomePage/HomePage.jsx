
import { Button } from '@mui/base'; 
import { useState } from 'react';

const HomePage = () => {
    const [isOpen, setIsOpen] = useState(false);

    const handleOpen = () => { setIsOpen(true); }
    const handleClose = () => { setIsOpen(false); }

    return (
        <div className="home-body">
            <h1>뇽챗 HomePage입니다</h1>

            <Button onClick={handleOpen}>
                로그인 하기
            </Button>

        

        </div>
    )

}

export default HomePage;