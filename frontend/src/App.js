import React from 'react'
import {
  Routes,
  Route
} from "react-router-dom";import {Container} from 'react-bootstrap'
import Header from './components/Header'
import Footer from './components/Footer'
import HomeScreen from './screens/HomeScreen'
import ProductScreen from './screens/ProductScreen'
import CartScreen from './screens/CartScreen'
import RegisterScreen from './screens/RegisterScreen'
import LoginScreen from './screens/LoginScreen'


function App() {
  return (
    <div>
      <Header/>
      <main className='py-3'>
      <Container>
           <Routes>
       
           <Route path='/login' component={LoginScreen} />

           <Route path='/register' component={RegisterScreen} />

             <Route path="/" element={<HomeScreen />} exact/>
             <Route path="/product/:id" element={<ProductScreen />} />
             <Route path="/cart/:id?" element={<CartScreen />} />


            
          


           </Routes>
      </Container>
      </main>
      <Footer/>  
  </div>
  );
}

export default App;