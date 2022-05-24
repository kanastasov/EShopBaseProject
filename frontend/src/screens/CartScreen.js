import React,{useEffect} from 'react'
import {useDispatch, useSelector} from 'react-redux'
import Message from '../components/Message'
import {Link} from 'react-router-dom'
import {Row,Col, ListGroup, Image, Form, Button, Card} from 'react-bootstrap'
import {addToCart}  from '../actions/cartActions'


const CartScreen = ({match, location, history}) => {
    const productId = match.params.productId


    const qty = location.search ? Number(location.search.split('=')[1]): 1


    const dispatch = useDispatch()

    const cart = useSelector(state => state.cart)
    const{cartItems} = cart

    useEffect(() => {
        if(productId) {
            dispatch(addToCart(productId, qty))
        }
    },[dispatch, productId,qty])

  return (
    <div>CartScreen</div>
  )
}

export default CartScreen