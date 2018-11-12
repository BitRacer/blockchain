package com.aristotle.blockchain.myblockchain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public class BlockchainTest {

    @Test
    public void testZeros() {
        assertEquals("0000", Utils.zeros(4));
    }

    public void testLotsOfZeros() {
        String str = "000000000000000000000000000000000000000000000000000000";
        assertEquals(str.length(), Utils.zeros(str.length()));

    }

    @Test
    public void testTheChain() {
        Blockchain blockchain = new Blockchain(4);
        blockchain.addBlock(blockchain.newBlock("this block"));
        blockchain.addBlock(blockchain.newBlock("that block"));
        blockchain.addBlock(blockchain.newBlock("yet another block"));

        System.out.println("Blockchain valid ? " + blockchain.isBlockChainValid());
        System.out.println(blockchain);
        assertTrue(blockchain.isBlockChainValid());
    }

    @Test
    public void testBadBlock() {

        Blockchain blockchain = new Blockchain(4);
        blockchain.addBlock(blockchain.newBlock("this block"));
        blockchain.addBlock(blockchain.newBlock("that block"));
        blockchain.addBlock(blockchain.newBlock("yet another block"));

        System.out.println("Blockchain valid ? " + blockchain.isBlockChainValid());
        System.out.println(blockchain);

        assertTrue(blockchain.isBlockChainValid());

        // add an invalid block to corrupt Blockchain
        blockchain.addBlock(new Block(15, System.currentTimeMillis(), "aaaabbb", "Block invalid"));

        System.out.println("Blockchain valid ? " + blockchain.isBlockChainValid());
        assertTrue(! blockchain.isBlockChainValid());
    }

}
