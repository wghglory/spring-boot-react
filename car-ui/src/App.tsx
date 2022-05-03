import './App.css';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';

import CarList from './components/CarList';
import Login from './components/Login';

function App() {
  const token = sessionStorage.getItem('jwt');

  return (
    <div className="App">
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6"> Car shop </Typography>
        </Toolbar>
      </AppBar>
      {token ? <CarList /> : <Login />}
    </div>
  );
}

export default App;
