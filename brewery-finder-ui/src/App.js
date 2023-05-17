import logo from './assets/hop.png';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>HopSeeker</h1>
        <h3>Wander. Sip. Repeat.</h3>
      </header>
      <div class="search-container">
        <form class="search-form">
          <input class="search" type="text" name="name" placeholder="Name"></input>
          <input class="search" type="text" name="city" placeholder="City"></input>
          <input class="search" type="text" name="state" placeholder="State"></input>
          <input class="search" type="text" name="zip" placeholder="Zip Code"></input>
        </form>
        <button type="submit" class="search">Search</button>
      </div>
    </div>
  );
}

export default App;
