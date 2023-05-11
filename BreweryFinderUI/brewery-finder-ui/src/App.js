import logo from './assets/hop.png';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>Brewery Finder</h1>
        <p>You must be 21 to enter.</p>
        <a
          className="App-link"
          href="#"
          target="_blank"
          rel="noopener noreferrer"
        >
          I am!
        </a>
      </header>
    </div>
  );
}

export default App;
