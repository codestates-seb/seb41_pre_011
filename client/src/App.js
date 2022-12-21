import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Board from './pages/Board';
import Board_write from './pages/Board_write';
import Home from './pages/Home';
import Login from './pages/Login';
import Mypage from './pages/Mypage';
import Sing_up from './pages/Sing_up';
import Board_List from './pages/Board_list';
import Tag_list from './pages/Tag_list';
import User_list from './pages/User_list';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/sing_up" element={<Sing_up />} />
          <Route path="/mypage" element={<Mypage />} />
          <Route path="/board" element={<Board />} />
          <Route path="/board_list" element={<Board_List />} />
          <Route path="/board_write" element={<Board_write />} />
          <Route path="/tag_list" element={<Tag_list />} />
          <Route path="/user_list" element={<User_list />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
