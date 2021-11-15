package com.myplace.letsgo.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.myplace.letsgo.business.abstracts.CommentService;
import com.myplace.letsgo.dataaccess.CommentDao;
import com.myplace.letsgo.dataaccess.CustomerDao;
import com.myplace.letsgo.dataaccess.RestaurantDao;
import com.myplace.letsgo.dto.CommentCreateRequest;
import com.myplace.letsgo.dto.CommentResponse;
import com.myplace.letsgo.dto.CommentUpdateRequest;
import com.myplace.letsgo.models.Comment;
import com.myplace.letsgo.models.Customer;
import com.myplace.letsgo.models.Restaurant;

import org.springframework.stereotype.Service;

@Service
public class CommentManager implements CommentService {

    private CommentDao commentDao;
    private RestaurantDao restaurantDao;
    private CustomerDao customerDao;

    @Override
    public List<CommentResponse> getAllComments(Optional<Long> customerid, Optional<Long> restaurantid) {
        List<Comment> list;
        if(customerid.isPresent() && restaurantid.isPresent()){
            list=commentDao.findByCustomerIdAndRestaurantId(customerid.get(),restaurantid.get());
        }else if(customerid.isPresent()){
            list=commentDao.findByCustomerId(customerid.get());
        }else if(restaurantid.isPresent()){
            list=commentDao.findByRestaurantId(restaurantid.get());
        }else{
            list=commentDao.findAll();
        }

        //herbir liste için comntresponse döndürecek map yazdık
        return list.stream().map(p ->new CommentResponse(p)).collect(Collectors.toList());
    }

    @Override
    public void deleteOneComment(Long commentid) {
        commentDao.deleteById(commentid);
        
    }

    @Override
    public Comment createOneComment(CommentCreateRequest request) {
        Optional<Restaurant> restaurant = restaurantDao.findById(request.getRestaurantid());
        Optional<Customer> customer = customerDao.findById(request.getCustomerid());

        if(restaurant.isPresent() && customer.isPresent()){
            Comment commentToSave = new Comment();

            commentToSave.setId(request.getId());
            commentToSave.setText(request.getText());
            commentToSave.setCustomer(customer.get());
            commentToSave.setRestaurant(restaurant.get());

            return commentDao.save(commentToSave);
        }

        return null;
    }

    @Override
    public Comment updateOneComment(Long commentid, CommentUpdateRequest request) {
        Optional<Comment> comment = commentDao.findById(commentid);
        if(comment.isPresent()){
            Comment commentToUpdate = comment.get();

            commentToUpdate.setText(request.getText());

            return commentDao.save(commentToUpdate);
        }       
        return null;
    }
    
}
