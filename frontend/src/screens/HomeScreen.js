import axios from 'axios'
import React, {useState, useEffect} from 'react'
import { Row,Col } from 'react-bootstrap'
// import products from '../products'
import Product from '../components/Product'

const HomeScreen = () => {
  const [products,setProducts] = useState([])

  useEffect(() =>{
      const fetchProducts = async () => {
      const {data} = await axios.get('/api/products')
      console.log(data)
      setProducts(data)
    }
    fetchProducts()
    },[])

  return (
    <>
        Latest Products
        <Row>
            {products.map(product =>(
                <Col key={product._id} sm={12} md={6} lg={4} xl={3}>
                    <Product product= {product} />
                </Col>
            ))}
        </Row>
    </>
  )
}

export default HomeScreen