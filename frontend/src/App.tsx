import DataTable from "compnents/DataTable";
import Footer from "compnents/Footer";
import NavBar from "compnents/NavBar";

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary">Olá Mundo!</h1>

        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
