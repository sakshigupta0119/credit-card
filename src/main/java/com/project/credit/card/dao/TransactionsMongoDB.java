package com.project.credit.card.dao;

import com.project.credit.card.dto.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.TransactionsMongo;
import com.project.credit.card.entities.transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import java.util.List;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class TransactionsMongoDB {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<transactions> getAllTransactions(){
        return mongoTemplate.findAll(transactions.class);
    }

    public transactions getTransactionsById(String transId){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(transId));
        return mongoTemplate.findOne(query, transactions.class);
    }

    public List<SpendByGender> getSpendHistoryByGender(){
        GroupOperation groupByGender = group("gender").sum("amt")
                .as("total_amount");

        MatchOperation allGenderCategory = match(new Criteria("gender").exists(true));

        ProjectionOperation includes = project("totalAmount").and("gender").previousOperation();

        SortOperation sortByGender = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));

        Aggregation aggregation = newAggregation(allGenderCategory,groupByGender,sortByGender,includes);
        AggregationResults<SpendByGender> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendByGender.class);
        List<SpendByGender> result = groupResults.getMappedResults();
        return result;

    }

    public List<SpendByCategory> getSpendingHistoryByCategory() {
        System.out.println("In DAO");
        GroupOperation groupByCategory = group("category").sum("amt")
                .as("total_amount");
        System.out.println("Grouping by category and aggregation on sum of amount");
        MatchOperation allCategories = match(new Criteria("category").exists(true));
        System.out.println("Match operation created");
        ProjectionOperation includes = project("totalAmount").and("category").previousOperation();
        System.out.println("Projection operation created");

        SortOperation sortByCategory = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));
        System.out.println("Sort operation created");

        Aggregation aggregation = newAggregation(allCategories,groupByCategory,sortByCategory,includes);
        AggregationResults<SpendByCategory> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendByCategory.class);
        System.out.println("Aggregation operation created");

        List<SpendByCategory> result = groupResults.getMappedResults();
        //System.out.println(result);
        return result;
    }
    

    public List<SpendByMerchant> getSpendingHistoryByMerchant() {

        GroupOperation groupByMerchant = group("merchant").sum("amt")
                .as("total_amount");

        MatchOperation allMerchants = match(new Criteria("merchant").exists(true));

        ProjectionOperation includes = project("totalAmount").and("merchant").previousOperation();

        SortOperation sortByMerchant = sort(Sort.by(Sort.Direction.DESC,"totalAmount"));

        Aggregation aggregation = newAggregation(allMerchants,groupByMerchant,sortByMerchant,includes);
        AggregationResults<SpendByMerchant> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendByMerchant.class);
        List<SpendByMerchant> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendByCity> getSpendingHistoryByCity() {

        GroupOperation groupByCity = group("city").sum("amt")
                .as("total_amount");

        MatchOperation allCities = match(new Criteria("city").exists(true));

        ProjectionOperation includes = project("total_amount").and("city").previousOperation();

        SortOperation sortByCity = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allCities,groupByCity,sortByCity,includes);
        AggregationResults<SpendByCity> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendByCity.class);
        List<SpendByCity> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendByState> getSpendingHistoryByState() {

        GroupOperation groupByState = group("state").sum("amt")
                .as("total_amount");

        MatchOperation allStates = match(new Criteria("state").exists(true));

        ProjectionOperation includes = project("total_amount").and("state").previousOperation();

        SortOperation sortByState = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allStates,groupByState,sortByState,includes);
        AggregationResults<SpendByState> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendByState.class);
        List<SpendByState> result = groupResults.getMappedResults();
        return result;
    }

    public List<SpendByOccupation> getSpendingHistoryByProfession() {

        GroupOperation groupByJob = group("Job").sum("amt")
                .as("total_amount");

        MatchOperation allJobs = match(new Criteria("Job").exists(true));

        ProjectionOperation includes = project("total_amount").and("Job").previousOperation();

        SortOperation sortByJob = sort(Sort.by(Sort.Direction.DESC,"total_amount"));

        Aggregation aggregation = newAggregation(allJobs,groupByJob,sortByJob,includes);
        AggregationResults<SpendByOccupation> groupResults = mongoTemplate
                .aggregate(aggregation, "transactions", SpendByOccupation.class);
        List<SpendByOccupation> result = groupResults.getMappedResults();
        return result;
    }

    public List<transactions> getLowValueTransactions() {
        MatchOperation matchLowValue = Aggregation.match(Criteria.where("amt").lte(100));
        SortOperation transactionsMongo = Aggregation.sort(Sort.by("amt"));

        Aggregation aggregation = newAggregation(matchLowValue, transactionsMongo);

        return mongoTemplate.aggregate(aggregation, "transactions", transactions.class).getMappedResults();
    }

    public List<transactions> getHighValueTransactions() {
        MatchOperation matchHighValue = Aggregation.match(Criteria.where("amt").gt(100)); // Adjust the threshold as needed
        SortOperation sortByAmountDescending = Aggregation.sort(Sort.by(Sort.Direction.DESC, "amt"));

        Aggregation aggregation = Aggregation.newAggregation(matchHighValue, sortByAmountDescending);

        return mongoTemplate.aggregate(aggregation, "transactions", transactions.class).getMappedResults();
    }

}
