import React from 'react'
import {
  Routes,
  Route
} from "react-router-dom";import {Container} from 'react-bootstrap'
import Header from './components/Header'
import Footer from './components/Footer'
import HomeScreen from './screens/HomeScreen'


function App() {
  return (
    <div>
      <Header/>
      <main className='py-3'>
      <Container>
           <Routes>
       


             <Route path="/" element={<HomeScreen />} exact/>

            
          


           </Routes>
      </Container>
      </main>
      <Footer/>  
  </div>
  );
}

export default App;