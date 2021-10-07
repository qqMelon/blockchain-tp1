package com.company;
import com.company.classes.Block;

import java.util.*;

public class Main {


    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    public static void main(String[] args) {

        ArrayList<String> transactions = new ArrayList<String>();

        //add our blocks to the blockchain ArrayList:
        blockchain.add(new Block(transactions, isGenesisValid("3F51B2C6BD96E7D2A6253806CE01CD1A237B1B390DE2F0BB2E163067A6325B84")));
        blockchain.add(new Block(transactions, blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block(transactions, blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block(transactions, blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block(transactions, blockchain.get(blockchain.size()-1).getHash()));
        blockchain.add(new Block(transactions, blockchain.get(blockchain.size()-1).getHash()));

        System.out.println(blockchain);
        System.out.println("The last block of blockchain is: " + getLastBlock());
        System.out.println("Blockchain is Valid: " + isChainValid());
    }

    public static String isGenesisValid(String input) {
        String genesisBlockHash = "3F51B2C6BD96E7D2A6253806CE01CD1A237B1B390DE2F0BB2E163067A6325B84";
        if(input.equals(genesisBlockHash)) {
            return input;
        }
        return Error;
    }

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i ++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i -1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current hashes was not equal !");
                return false;
            }
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hash was not equal !");
                return false;
            }
        }
        return true;
    }

    public static Block getLastBlock() {
        Block lastBlock;
        lastBlock = blockchain.get(blockchain.size() -1);
        return lastBlock;
    }
}
