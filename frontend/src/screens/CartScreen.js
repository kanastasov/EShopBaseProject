import React, {useEffect} from 'react'
import {Link,useParams,useSearchParams } from 'react-router-dom'
import {useDispatch, useSelector} from 'react-redux'
import {Row, Col, ListGroup, Image, Form, Button, Card} from 'react-bootstrap'
import Message from '../components/Message'
import { addToCart,removeFromCart } from './../actions/cartActions';


// need to fix add to cart button redux state
const CartScreen = ({match, location, history}) => {

    const productId = useParams();
    const [searchParams] = useSearchParams();

    console.log('searchParams ',searchParams)
    
    console.log('productId ',productId)

    

    const qty = 3

    // const qty = useParams();
    // const qty = searchParams.get('qty') ? Number(searchParams.get('qty').split('=')[1]) : 1
    // const qty = 1
    console.log('qty ' ,qty)

    const dispatch = useDispatch()

    const cart = useSelector(state => state.cart)
    console.log('cart ' ,cart)

    const {cartItems} = cart
    //add to cart button not adding items in carItems Reducer
        console.log('cartItems ' ,cartItems)


    useEffect(() => {
      if(productId) {
        dispatch(addToCart(productId.id, qty))
      }
    },[dispatch, productId, qty])
    // console.log(qty)

    const removeFromCartHandler =(id) => {
      dispatch(removeFromCart(id))
      console.log(id)
    }

    const checkoutHandler = () => {
      history.push('/login?redirect=shipping')
      // console.log('checkoutHandler')
    }
  return (
    <Row>
      <Col md={8}>
          <h1>Shopping Cart</h1>
          {cartItems.length === 0 ? 
          <Message>Your cart is empty <Link to="/">Go back</Link> </Message> : (
            <ListGroup variant='flush'>
              {cartItems.map(item => (
                <ListGroup.Item key={item.product}>
                  <Row>
                      <Col md={2}>
                        <Image src={item.image} alt={item.name} flud rounded />
                      </Col>

                        <Col md={3}>
                            <Link to={`/product/${item.product}`}>{item.name}
                             </Link>
                      </Col>

                        <Col md={2}>
                            {item.price}
                      </Col>

                        <Col md={2}>
                              <Form.Control
                                 as='select' value={item.qty}
                                 onChange={(e) => dispatch(addToCart(item.product, Number(e.target.value)))}>
                                 {
                                [...Array(item.countInStock).keys()].map(x => (<option kye={x+1} value={x+1}> {x+1} </option>))
                                }
                                </Form.Control>
                       </Col>

                        <Col md={2}>
                            <Button type='button' variant='light' onClick={() => removeFromCartHandler(item.product)}> 
                            <i className='fas fa-trash'> </i>
                            </Button>
                       </Col>

                  </Row>
                </ListGroup.Item>
              ))}
             </ListGroup>
          )}
      </Col>
          <Card>
            <ListGroup variant = 'flush'>
                <ListGroup.Item>
                    <h2>
                    Subtotal ({cartItems.reduce((acc, item) => acc + item.qty, 0)})
                    items
                  </h2>
                  $ {cartItems
                .reduce((acc, item) => acc + item.qty * item.price, 0)
                .toFixed(2)}
                </ListGroup.Item>

              <ListGroup.Item>
                <Button type='button' className='btn-block'
                disabled={cartItems.length===0}
                onClick={checkoutHandler}>
                </Button>
              </ListGroup.Item>
            </ListGroup>
          </Card>
       <Col md={4}>
          
      </Col>
     
    </Row>
  )
}

export default CartScreen