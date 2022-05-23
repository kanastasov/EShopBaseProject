import React from 'react'
import {Spinner} from 'react-bootstrap'


const Loader = () => {
  return (
    <Spinner animation='bprder' role='status' style ={{width:'100px', height: '100px', margin: 'auto', display: 'block'}}>
        
        <span class='sr-onyl'>Loading...</span></Spinner>
  )
}

export default Loader 