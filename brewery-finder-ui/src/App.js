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
      <div class="about">
        <p class="main">Discover Pennsylvania's Finest Breweries with HopSeeker! Wander through the world of craft beer, sip on exquisite flavors, and repeat the adventure.</p>
        <p class="coming-soon">Coming soon: Find breweries near you!</p>
      </div>
      <div class="search-container">
        <form class="search-form">
          <input class="search" type="text" name="name" placeholder="Name"></input>
          <input class="search" type="text" name="city" placeholder="City"></input>
          {/* <input class="search" type="text" name="state" placeholder="State"></input> */}
          <input class="search" type="text" name="zip" placeholder="Zip Code"></input>
        </form>
        <button type="submit" class="search">Search</button>
        <button type="button" class="location">Beer Near Here</button>
      </div>
    </div>
  );
}

export default App;
