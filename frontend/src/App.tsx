import { HeaderContainer } from "./components/Header";
import { BodyContainer } from "./components/Body";
import { FooterContainer } from "./components/Footer";
function Header() {
  return <HeaderContainer></HeaderContainer>;
}

function Body() {
  return <BodyContainer></BodyContainer>;
}

function Footer() {
  return <FooterContainer></FooterContainer>;
}

function App() {
  return (
    <div className="container-fluid">
      <Header></Header>
      <Body></Body>
      <Footer></Footer>
    </div>
  );
}

export default App;
