import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import { Switch } from "react-router-dom";
import { Route } from "react-router-dom";
import { BrowserRouter } from "react-router-dom";

function Routes() {
    return (
        <BrowserRouter>
          <Switch>
             <Route path="/" exact>
               <Home/>
             </Route>
          
             <Route path="/dashboard">
               <Dashboard/>
             </Route>         
          </Switch>

        </BrowserRouter>
    );
}

export default Routes;