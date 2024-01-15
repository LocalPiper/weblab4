import { HeaderContainer } from "./components/Header";
import { BodyContainer } from "./components/Body";
import { FooterContainer } from "./components/Footer";
export function Header() {
  return <HeaderContainer></HeaderContainer>;
}

function Body() {
  return <BodyContainer></BodyContainer>;
}

export function Footer() {
  return <FooterContainer></FooterContainer>;
}
export default function Main() {
  return (
    <>
      <div className="container-fluid">
        <Header></Header>
        <Body></Body>
        <Footer></Footer>
      </div>
    </>
  );
}