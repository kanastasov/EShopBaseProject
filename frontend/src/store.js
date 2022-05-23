import { createStore, combineReducers, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'
import { composeWithDevTools } from 'redux-devtools-extension'
import {porductListReducer, porductDetailsReducer} from './reducers/productReducers'

const reducer = combineReducers({
    productList: porductListReducer,
    productDetails: porductDetailsReducer,

  })


  const initialState={
  }
  const middleware = [thunk]
 
  const store = createStore(
    reducer,
    initialState,
    composeWithDevTools(applyMiddleware(...middleware))
  )
export default store