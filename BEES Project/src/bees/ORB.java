/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bees;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author admin
 */
public class ORB
{
     public static List<FeaturePoint> detectWithNonMax(int[][] image, int w, int h, int threshold, int N) 
	{
		List<FeaturePoint> features = detect(image, w, h, threshold, -1);
		features = nonMaxSuppression(w, h, features);
		int count = features.size();
		if (N == -1)
			return features;
		else
			return features.subList(0, (count > N)? N : count);
	}

    public static List<FeaturePoint> detect(int[][] image, int w, int h, int threshold, int N)
	{
		ArrayList<FeaturePoint> corners = new ArrayList<FeaturePoint>();
		int count = 0;
		
		for (int y = 4; y < h - 4; ++y) {
			for (int x = 4; x < w - 4; ++x) {
				int cb = image[y][x] + threshold;
				int c_b = image[y][x] - threshold;
				if (image[y+3][x+0] > cb) 
				 if (image[y+3][x+1] > cb) 
				  if (image[y+2][x+2] > cb) 
				   if (image[y+1][x+3] > cb) 
				    if (image[y+0][x+3] > cb) 
				     if (image[y+-1][x+3] > cb) 
				      if (image[y+-2][x+2] > cb) 
				       if (image[y+-3][x+1] > cb) 
				        if (image[y+-3][x+0] > cb) 
				         if (image[y+-3][x+-1] > cb) 
				          if (image[y+-2][x+-2] > cb) 
				           if (image[y+-1][x+-3] > cb) 
				            {;}
				           else
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				          else
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				         else
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				        else
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				       else
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				      else
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				     else
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				    else if (image[y+0][x+3] < c_b) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else if (image[y+-3][x+0] < c_b) 
				      if (image[y+-1][x+3] < c_b)
				       if (image[y+-2][x+2] < c_b)
				        if (image[y+-3][x+1] < c_b)
				         if (image[y+-3][x+-1] < c_b)
				          if (image[y+-2][x+-2] < c_b)
				           if (image[y+-1][x+-3] < c_b)
				            if (image[y+0][x+-3] < c_b)
				             if (image[y+1][x+-3] < c_b)
				              if (image[y+2][x+-2] < c_b)
				               if (image[y+3][x+-1] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				   else if (image[y+1][x+3] < c_b) 
				    if (image[y+3][x+-1] > cb) 
				     if (image[y+-3][x+1] > cb) 
				      if (image[y+-3][x+0] > cb) 
				       if (image[y+-3][x+-1] > cb) 
				        if (image[y+-2][x+-2] > cb) 
				         if (image[y+-1][x+-3] > cb) 
				          if (image[y+0][x+-3] > cb) 
				           if (image[y+1][x+-3] > cb) 
				            if (image[y+2][x+-2] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else if (image[y+-3][x+1] < c_b) 
				      if (image[y+0][x+3] < c_b)
				       if (image[y+-1][x+3] < c_b)
				        if (image[y+-2][x+2] < c_b)
				         if (image[y+-3][x+0] < c_b)
				          if (image[y+-3][x+-1] < c_b)
				           if (image[y+-2][x+-2] < c_b)
				            if (image[y+-1][x+-3] < c_b)
				             if (image[y+0][x+-3] < c_b)
				              if (image[y+1][x+-3] < c_b)
				               if (image[y+2][x+-2] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     if (image[y+0][x+3] < c_b)
				      if (image[y+-1][x+3] < c_b)
				       if (image[y+-2][x+2] < c_b)
				        if (image[y+-3][x+1] < c_b)
				         if (image[y+-3][x+0] < c_b)
				          if (image[y+-3][x+-1] < c_b)
				           if (image[y+-2][x+-2] < c_b)
				            if (image[y+-1][x+-3] < c_b)
				             if (image[y+0][x+-3] < c_b)
				              if (image[y+1][x+-3] < c_b)
				               if (image[y+2][x+-2] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				   else
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else if (image[y+-3][x+1] < c_b) 
				     if (image[y+0][x+3] < c_b)
				      if (image[y+-1][x+3] < c_b)
				       if (image[y+-2][x+2] < c_b)
				        if (image[y+-3][x+0] < c_b)
				         if (image[y+-3][x+-1] < c_b)
				          if (image[y+-2][x+-2] < c_b)
				           if (image[y+-1][x+-3] < c_b)
				            if (image[y+0][x+-3] < c_b)
				             if (image[y+1][x+-3] < c_b)
				              if (image[y+2][x+-2] < c_b)
				               if (image[y+3][x+-1] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				  else if (image[y+2][x+2] < c_b) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               if (image[y+-1][x+3] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else if (image[y+-2][x+2] < c_b) 
				    if (image[y+0][x+3] < c_b)
				     if (image[y+-1][x+3] < c_b)
				      if (image[y+-3][x+1] < c_b)
				       if (image[y+-3][x+0] < c_b)
				        if (image[y+-3][x+-1] < c_b)
				         if (image[y+-2][x+-2] < c_b)
				          if (image[y+-1][x+-3] < c_b)
				           if (image[y+0][x+-3] < c_b)
				            if (image[y+1][x+-3] < c_b)
				             if (image[y+1][x+3] < c_b)
				              {;}
				             else
				              if (image[y+2][x+-2] < c_b)
				               if (image[y+3][x+-1] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               if (image[y+-1][x+3] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else if (image[y+-2][x+2] < c_b) 
				    if (image[y+0][x+3] < c_b)
				     if (image[y+-1][x+3] < c_b)
				      if (image[y+-3][x+1] < c_b)
				       if (image[y+-3][x+0] < c_b)
				        if (image[y+-3][x+-1] < c_b)
				         if (image[y+-2][x+-2] < c_b)
				          if (image[y+-1][x+-3] < c_b)
				           if (image[y+0][x+-3] < c_b)
				            if (image[y+1][x+-3] < c_b)
				             if (image[y+2][x+-2] < c_b)
				              if (image[y+1][x+3] < c_b)
				               {;}
				              else
				               if (image[y+3][x+-1] < c_b)
				                {;}
				               else
				                continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				 else if (image[y+3][x+1] < c_b) 
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+2][x+2] > cb) 
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+-1][x+3] < c_b) 
				   if (image[y+0][x+3] < c_b)
				    if (image[y+-2][x+2] < c_b)
				     if (image[y+-3][x+1] < c_b)
				      if (image[y+-3][x+0] < c_b)
				       if (image[y+-3][x+-1] < c_b)
				        if (image[y+-2][x+-2] < c_b)
				         if (image[y+-1][x+-3] < c_b)
				          if (image[y+0][x+-3] < c_b)
				           if (image[y+1][x+3] < c_b)
				            if (image[y+2][x+2] < c_b)
				             {;}
				            else
				             if (image[y+1][x+-3] < c_b)
				              if (image[y+2][x+-2] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+1][x+-3] < c_b)
				             if (image[y+2][x+-2] < c_b)
				              if (image[y+3][x+-1] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				 else
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+-3] > cb) 
				           if (image[y+2][x+-2] > cb) 
				            if (image[y+3][x+-1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+2][x+2] > cb) 
				             if (image[y+1][x+3] > cb) 
				              if (image[y+0][x+3] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+-1][x+3] < c_b) 
				   if (image[y+0][x+3] < c_b)
				    if (image[y+-2][x+2] < c_b)
				     if (image[y+-3][x+1] < c_b)
				      if (image[y+-3][x+0] < c_b)
				       if (image[y+-3][x+-1] < c_b)
				        if (image[y+-2][x+-2] < c_b)
				         if (image[y+-1][x+-3] < c_b)
				          if (image[y+0][x+-3] < c_b)
				           if (image[y+1][x+-3] < c_b)
				            if (image[y+1][x+3] < c_b)
				             if (image[y+2][x+2] < c_b)
				              {;}
				             else
				              if (image[y+2][x+-2] < c_b)
				               {;}
				              else
				               continue;
				            else
				             if (image[y+2][x+-2] < c_b)
				              if (image[y+3][x+-1] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				else if (image[y+3][x+0] < c_b) 
				 if (image[y+3][x+1] > cb) 
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+0][x+3] > cb) 
				    if (image[y+-2][x+2] > cb) 
				     if (image[y+-3][x+1] > cb) 
				      if (image[y+-3][x+0] > cb) 
				       if (image[y+-3][x+-1] > cb) 
				        if (image[y+-2][x+-2] > cb) 
				         if (image[y+-1][x+-3] > cb) 
				          if (image[y+0][x+-3] > cb) 
				           if (image[y+1][x+3] > cb) 
				            if (image[y+2][x+2] > cb) 
				             {;}
				            else
				             if (image[y+1][x+-3] > cb) 
				              if (image[y+2][x+-2] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+1][x+-3] > cb) 
				             if (image[y+2][x+-2] > cb) 
				              if (image[y+3][x+-1] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+-1][x+3] < c_b) 
				   if (image[y+-2][x+2] < c_b)
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+2][x+2] < c_b)
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				 else if (image[y+3][x+1] < c_b) 
				  if (image[y+2][x+2] > cb) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+0][x+3] > cb) 
				     if (image[y+-1][x+3] > cb) 
				      if (image[y+-3][x+1] > cb) 
				       if (image[y+-3][x+0] > cb) 
				        if (image[y+-3][x+-1] > cb) 
				         if (image[y+-2][x+-2] > cb) 
				          if (image[y+-1][x+-3] > cb) 
				           if (image[y+0][x+-3] > cb) 
				            if (image[y+1][x+-3] > cb) 
				             if (image[y+1][x+3] > cb) 
				              {;}
				             else
				              if (image[y+2][x+-2] > cb) 
				               if (image[y+3][x+-1] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else if (image[y+-2][x+2] < c_b) 
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               if (image[y+-1][x+3] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+2][x+2] < c_b) 
				   if (image[y+1][x+3] > cb) 
				    if (image[y+3][x+-1] < c_b)
				     if (image[y+-3][x+1] > cb) 
				      if (image[y+0][x+3] > cb) 
				       if (image[y+-1][x+3] > cb) 
				        if (image[y+-2][x+2] > cb) 
				         if (image[y+-3][x+0] > cb) 
				          if (image[y+-3][x+-1] > cb) 
				           if (image[y+-2][x+-2] > cb) 
				            if (image[y+-1][x+-3] > cb) 
				             if (image[y+0][x+-3] > cb) 
				              if (image[y+1][x+-3] > cb) 
				               if (image[y+2][x+-2] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else if (image[y+-3][x+1] < c_b) 
				      if (image[y+-3][x+0] < c_b)
				       if (image[y+-3][x+-1] < c_b)
				        if (image[y+-2][x+-2] < c_b)
				         if (image[y+-1][x+-3] < c_b)
				          if (image[y+0][x+-3] < c_b)
				           if (image[y+1][x+-3] < c_b)
				            if (image[y+2][x+-2] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     if (image[y+0][x+3] > cb) 
				      if (image[y+-1][x+3] > cb) 
				       if (image[y+-2][x+2] > cb) 
				        if (image[y+-3][x+1] > cb) 
				         if (image[y+-3][x+0] > cb) 
				          if (image[y+-3][x+-1] > cb) 
				           if (image[y+-2][x+-2] > cb) 
				            if (image[y+-1][x+-3] > cb) 
				             if (image[y+0][x+-3] > cb) 
				              if (image[y+1][x+-3] > cb) 
				               if (image[y+2][x+-2] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				   else if (image[y+1][x+3] < c_b) 
				    if (image[y+0][x+3] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-1][x+3] > cb) 
				       if (image[y+-2][x+2] > cb) 
				        if (image[y+-3][x+1] > cb) 
				         if (image[y+-3][x+-1] > cb) 
				          if (image[y+-2][x+-2] > cb) 
				           if (image[y+-1][x+-3] > cb) 
				            if (image[y+0][x+-3] > cb) 
				             if (image[y+1][x+-3] > cb) 
				              if (image[y+2][x+-2] > cb) 
				               if (image[y+3][x+-1] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else if (image[y+-3][x+0] < c_b) 
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else if (image[y+0][x+3] < c_b) 
				     if (image[y+-1][x+3] < c_b)
				      if (image[y+-2][x+2] < c_b)
				       if (image[y+-3][x+1] < c_b)
				        if (image[y+-3][x+0] < c_b)
				         if (image[y+-3][x+-1] < c_b)
				          if (image[y+-2][x+-2] < c_b)
				           if (image[y+-1][x+-3] < c_b)
				            {;}
				           else
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				          else
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				         else
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				        else
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				       else
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				      else
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				     else
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				    else
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				   else
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+0][x+3] > cb) 
				      if (image[y+-1][x+3] > cb) 
				       if (image[y+-2][x+2] > cb) 
				        if (image[y+-3][x+0] > cb) 
				         if (image[y+-3][x+-1] > cb) 
				          if (image[y+-2][x+-2] > cb) 
				           if (image[y+-1][x+-3] > cb) 
				            if (image[y+0][x+-3] > cb) 
				             if (image[y+1][x+-3] > cb) 
				              if (image[y+2][x+-2] > cb) 
				               if (image[y+3][x+-1] > cb) 
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else if (image[y+-3][x+1] < c_b) 
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				  else
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+0][x+3] > cb) 
				     if (image[y+-1][x+3] > cb) 
				      if (image[y+-3][x+1] > cb) 
				       if (image[y+-3][x+0] > cb) 
				        if (image[y+-3][x+-1] > cb) 
				         if (image[y+-2][x+-2] > cb) 
				          if (image[y+-1][x+-3] > cb) 
				           if (image[y+0][x+-3] > cb) 
				            if (image[y+1][x+-3] > cb) 
				             if (image[y+2][x+-2] > cb) 
				              if (image[y+1][x+3] > cb) 
				               {;}
				              else
				               if (image[y+3][x+-1] > cb) 
				                {;}
				               else
				                continue;
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else if (image[y+-2][x+2] < c_b) 
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               if (image[y+-1][x+3] < c_b)
				                {;}
				               else
				                continue;
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				 else
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+0][x+3] > cb) 
				    if (image[y+-2][x+2] > cb) 
				     if (image[y+-3][x+1] > cb) 
				      if (image[y+-3][x+0] > cb) 
				       if (image[y+-3][x+-1] > cb) 
				        if (image[y+-2][x+-2] > cb) 
				         if (image[y+-1][x+-3] > cb) 
				          if (image[y+0][x+-3] > cb) 
				           if (image[y+1][x+-3] > cb) 
				            if (image[y+1][x+3] > cb) 
				             if (image[y+2][x+2] > cb) 
				              {;}
				             else
				              if (image[y+2][x+-2] > cb) 
				               {;}
				              else
				               continue;
				            else
				             if (image[y+2][x+-2] > cb) 
				              if (image[y+3][x+-1] > cb) 
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else if (image[y+-1][x+3] < c_b) 
				   if (image[y+-2][x+2] < c_b)
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+-3] < c_b)
				           if (image[y+2][x+-2] < c_b)
				            if (image[y+3][x+-1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				           else
				            if (image[y+2][x+2] < c_b)
				             if (image[y+1][x+3] < c_b)
				              if (image[y+0][x+3] < c_b)
				               {;}
				              else
				               continue;
				             else
				              continue;
				            else
				             continue;
				          else
				           continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				else
				 if (image[y+0][x+3] > cb) 
				  if (image[y+-1][x+3] > cb) 
				   if (image[y+-2][x+2] > cb) 
				    if (image[y+-3][x+1] > cb) 
				     if (image[y+-3][x+0] > cb) 
				      if (image[y+-3][x+-1] > cb) 
				       if (image[y+-2][x+-2] > cb) 
				        if (image[y+-1][x+-3] > cb) 
				         if (image[y+0][x+-3] > cb) 
				          if (image[y+1][x+3] > cb) 
				           if (image[y+2][x+2] > cb) 
				            if (image[y+3][x+1] > cb) 
				             {;}
				            else
				             if (image[y+1][x+-3] > cb) 
				              {;}
				             else
				              continue;
				           else
				            if (image[y+1][x+-3] > cb) 
				             if (image[y+2][x+-2] > cb) 
				              {;}
				             else
				              continue;
				            else
				             continue;
				          else
				           if (image[y+1][x+-3] > cb) 
				            if (image[y+2][x+-2] > cb) 
				             if (image[y+3][x+-1] > cb) 
				              {;}
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				 else if (image[y+0][x+3] < c_b) 
				  if (image[y+-1][x+3] < c_b)
				   if (image[y+-2][x+2] < c_b)
				    if (image[y+-3][x+1] < c_b)
				     if (image[y+-3][x+0] < c_b)
				      if (image[y+-3][x+-1] < c_b)
				       if (image[y+-2][x+-2] < c_b)
				        if (image[y+-1][x+-3] < c_b)
				         if (image[y+0][x+-3] < c_b)
				          if (image[y+1][x+3] < c_b)
				           if (image[y+2][x+2] < c_b)
				            if (image[y+3][x+1] < c_b)
				             {;}
				            else
				             if (image[y+1][x+-3] < c_b)
				              {;}
				             else
				              continue;
				           else
				            if (image[y+1][x+-3] < c_b)
				             if (image[y+2][x+-2] < c_b)
				              {;}
				             else
				              continue;
				            else
				             continue;
				          else
				           if (image[y+1][x+-3] < c_b)
				            if (image[y+2][x+-2] < c_b)
				             if (image[y+3][x+-1] < c_b)
				              {;}
				             else
				              continue;
				            else
				             continue;
				           else
				            continue;
				         else
				          continue;
				        else
				         continue;
				       else
				        continue;
				      else
				       continue;
				     else
				      continue;
				    else
				     continue;
				   else
				    continue;
				  else
				   continue;
				 else
				  continue;
				corners.add(new FeaturePoint(x, y));
				count++;
			}
		}
		for (int i = 0; i < count; ++i) {
			int x = corners.get(i).x();
			int y = corners.get(i).y();
			corners.get(i).score(cornerScore(image, x, y));
		}
		Collections.sort(corners, Collections.reverseOrder());
		if (N == -1)
			return corners;
		else 
			return corners.subList(0, (N < count)? N : count);
}
    
    
    private static int cornerScore(int[][] image, int posx, int posy)
	{
		int bmin = 0;
		int bmax = 255;
		int b = (bmax + bmin)/2;
	    
		while (true)
		{
			if (isCorner(image, posx, posy, b)) {
				bmin = b;
			} else {
				bmax = b;
			}
	        
			if (bmin == bmax - 1 || bmin == bmax) {
				return bmin;
			}

			b = (bmin + bmax) / 2;
		}
	}

    private static boolean isCorner(int[][] image, int posx, int posy, int threshold)
	{		
		int cb = image[posy][posx] + threshold;
		int c_b = image[posy][posx] - threshold;
		if (image[posy+3][posx+0] > cb) 
		 if (image[posy+3][posx+1] > cb) 
		  if (image[posy+2][posx+2] > cb) 
		   if (image[posy+1][posx+3] > cb) 
		    if (image[posy+0][posx+3] > cb) 
		     if (image[posy+-1][posx+3] > cb) 
		      if (image[posy+-2][posx+2] > cb) 
		       if (image[posy+-3][posx+1] > cb) 
		        if (image[posy+-3][posx+0] > cb) 
		         if (image[posy+-3][posx+-1] > cb) 
		          if (image[posy+-2][posx+-2] > cb) 
		           if (image[posy+-1][posx+-3] > cb) 
		            return true;
		           else
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		          else
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		         else
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		        else
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		       else
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		      else
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		     else
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		    else if (image[posy+0][posx+3] < c_b) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else if (image[posy+-3][posx+0] < c_b) 
		      if (image[posy+-1][posx+3] < c_b)
		       if (image[posy+-2][posx+2] < c_b)
		        if (image[posy+-3][posx+1] < c_b)
		         if (image[posy+-3][posx+-1] < c_b)
		          if (image[posy+-2][posx+-2] < c_b)
		           if (image[posy+-1][posx+-3] < c_b)
		            if (image[posy+0][posx+-3] < c_b)
		             if (image[posy+1][posx+-3] < c_b)
		              if (image[posy+2][posx+-2] < c_b)
		               if (image[posy+3][posx+-1] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		   else if (image[posy+1][posx+3] < c_b) 
		    if (image[posy+3][posx+-1] > cb) 
		     if (image[posy+-3][posx+1] > cb) 
		      if (image[posy+-3][posx+0] > cb) 
		       if (image[posy+-3][posx+-1] > cb) 
		        if (image[posy+-2][posx+-2] > cb) 
		         if (image[posy+-1][posx+-3] > cb) 
		          if (image[posy+0][posx+-3] > cb) 
		           if (image[posy+1][posx+-3] > cb) 
		            if (image[posy+2][posx+-2] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else if (image[posy+-3][posx+1] < c_b) 
		      if (image[posy+0][posx+3] < c_b)
		       if (image[posy+-1][posx+3] < c_b)
		        if (image[posy+-2][posx+2] < c_b)
		         if (image[posy+-3][posx+0] < c_b)
		          if (image[posy+-3][posx+-1] < c_b)
		           if (image[posy+-2][posx+-2] < c_b)
		            if (image[posy+-1][posx+-3] < c_b)
		             if (image[posy+0][posx+-3] < c_b)
		              if (image[posy+1][posx+-3] < c_b)
		               if (image[posy+2][posx+-2] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     if (image[posy+0][posx+3] < c_b)
		      if (image[posy+-1][posx+3] < c_b)
		       if (image[posy+-2][posx+2] < c_b)
		        if (image[posy+-3][posx+1] < c_b)
		         if (image[posy+-3][posx+0] < c_b)
		          if (image[posy+-3][posx+-1] < c_b)
		           if (image[posy+-2][posx+-2] < c_b)
		            if (image[posy+-1][posx+-3] < c_b)
		             if (image[posy+0][posx+-3] < c_b)
		              if (image[posy+1][posx+-3] < c_b)
		               if (image[posy+2][posx+-2] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		   else
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else if (image[posy+-3][posx+1] < c_b) 
		     if (image[posy+0][posx+3] < c_b)
		      if (image[posy+-1][posx+3] < c_b)
		       if (image[posy+-2][posx+2] < c_b)
		        if (image[posy+-3][posx+0] < c_b)
		         if (image[posy+-3][posx+-1] < c_b)
		          if (image[posy+-2][posx+-2] < c_b)
		           if (image[posy+-1][posx+-3] < c_b)
		            if (image[posy+0][posx+-3] < c_b)
		             if (image[posy+1][posx+-3] < c_b)
		              if (image[posy+2][posx+-2] < c_b)
		               if (image[posy+3][posx+-1] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		  else if (image[posy+2][posx+2] < c_b) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               if (image[posy+-1][posx+3] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else if (image[posy+-2][posx+2] < c_b) 
		    if (image[posy+0][posx+3] < c_b)
		     if (image[posy+-1][posx+3] < c_b)
		      if (image[posy+-3][posx+1] < c_b)
		       if (image[posy+-3][posx+0] < c_b)
		        if (image[posy+-3][posx+-1] < c_b)
		         if (image[posy+-2][posx+-2] < c_b)
		          if (image[posy+-1][posx+-3] < c_b)
		           if (image[posy+0][posx+-3] < c_b)
		            if (image[posy+1][posx+-3] < c_b)
		             if (image[posy+1][posx+3] < c_b)
		              return true;
		             else
		              if (image[posy+2][posx+-2] < c_b)
		               if (image[posy+3][posx+-1] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               if (image[posy+-1][posx+3] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else if (image[posy+-2][posx+2] < c_b) 
		    if (image[posy+0][posx+3] < c_b)
		     if (image[posy+-1][posx+3] < c_b)
		      if (image[posy+-3][posx+1] < c_b)
		       if (image[posy+-3][posx+0] < c_b)
		        if (image[posy+-3][posx+-1] < c_b)
		         if (image[posy+-2][posx+-2] < c_b)
		          if (image[posy+-1][posx+-3] < c_b)
		           if (image[posy+0][posx+-3] < c_b)
		            if (image[posy+1][posx+-3] < c_b)
		             if (image[posy+2][posx+-2] < c_b)
		              if (image[posy+1][posx+3] < c_b)
		               return true;
		              else
		               if (image[posy+3][posx+-1] < c_b)
		                return true;
		               else
		                return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		 else if (image[posy+3][posx+1] < c_b) 
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+2][posx+2] > cb) 
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+-1][posx+3] < c_b) 
		   if (image[posy+0][posx+3] < c_b)
		    if (image[posy+-2][posx+2] < c_b)
		     if (image[posy+-3][posx+1] < c_b)
		      if (image[posy+-3][posx+0] < c_b)
		       if (image[posy+-3][posx+-1] < c_b)
		        if (image[posy+-2][posx+-2] < c_b)
		         if (image[posy+-1][posx+-3] < c_b)
		          if (image[posy+0][posx+-3] < c_b)
		           if (image[posy+1][posx+3] < c_b)
		            if (image[posy+2][posx+2] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+-3] < c_b)
		              if (image[posy+2][posx+-2] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+1][posx+-3] < c_b)
		             if (image[posy+2][posx+-2] < c_b)
		              if (image[posy+3][posx+-1] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		 else
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+-3] > cb) 
		           if (image[posy+2][posx+-2] > cb) 
		            if (image[posy+3][posx+-1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+2][posx+2] > cb) 
		             if (image[posy+1][posx+3] > cb) 
		              if (image[posy+0][posx+3] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+-1][posx+3] < c_b) 
		   if (image[posy+0][posx+3] < c_b)
		    if (image[posy+-2][posx+2] < c_b)
		     if (image[posy+-3][posx+1] < c_b)
		      if (image[posy+-3][posx+0] < c_b)
		       if (image[posy+-3][posx+-1] < c_b)
		        if (image[posy+-2][posx+-2] < c_b)
		         if (image[posy+-1][posx+-3] < c_b)
		          if (image[posy+0][posx+-3] < c_b)
		           if (image[posy+1][posx+-3] < c_b)
		            if (image[posy+1][posx+3] < c_b)
		             if (image[posy+2][posx+2] < c_b)
		              return true;
		             else
		              if (image[posy+2][posx+-2] < c_b)
		               return true;
		              else
		               return false;
		            else
		             if (image[posy+2][posx+-2] < c_b)
		              if (image[posy+3][posx+-1] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		else if (image[posy+3][posx+0] < c_b) 
		 if (image[posy+3][posx+1] > cb) 
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+0][posx+3] > cb) 
		    if (image[posy+-2][posx+2] > cb) 
		     if (image[posy+-3][posx+1] > cb) 
		      if (image[posy+-3][posx+0] > cb) 
		       if (image[posy+-3][posx+-1] > cb) 
		        if (image[posy+-2][posx+-2] > cb) 
		         if (image[posy+-1][posx+-3] > cb) 
		          if (image[posy+0][posx+-3] > cb) 
		           if (image[posy+1][posx+3] > cb) 
		            if (image[posy+2][posx+2] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+-3] > cb) 
		              if (image[posy+2][posx+-2] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+1][posx+-3] > cb) 
		             if (image[posy+2][posx+-2] > cb) 
		              if (image[posy+3][posx+-1] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+-1][posx+3] < c_b) 
		   if (image[posy+-2][posx+2] < c_b)
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+2][posx+2] < c_b)
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		 else if (image[posy+3][posx+1] < c_b) 
		  if (image[posy+2][posx+2] > cb) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+0][posx+3] > cb) 
		     if (image[posy+-1][posx+3] > cb) 
		      if (image[posy+-3][posx+1] > cb) 
		       if (image[posy+-3][posx+0] > cb) 
		        if (image[posy+-3][posx+-1] > cb) 
		         if (image[posy+-2][posx+-2] > cb) 
		          if (image[posy+-1][posx+-3] > cb) 
		           if (image[posy+0][posx+-3] > cb) 
		            if (image[posy+1][posx+-3] > cb) 
		             if (image[posy+1][posx+3] > cb) 
		              return true;
		             else
		              if (image[posy+2][posx+-2] > cb) 
		               if (image[posy+3][posx+-1] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else if (image[posy+-2][posx+2] < c_b) 
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               if (image[posy+-1][posx+3] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+2][posx+2] < c_b) 
		   if (image[posy+1][posx+3] > cb) 
		    if (image[posy+3][posx+-1] < c_b)
		     if (image[posy+-3][posx+1] > cb) 
		      if (image[posy+0][posx+3] > cb) 
		       if (image[posy+-1][posx+3] > cb) 
		        if (image[posy+-2][posx+2] > cb) 
		         if (image[posy+-3][posx+0] > cb) 
		          if (image[posy+-3][posx+-1] > cb) 
		           if (image[posy+-2][posx+-2] > cb) 
		            if (image[posy+-1][posx+-3] > cb) 
		             if (image[posy+0][posx+-3] > cb) 
		              if (image[posy+1][posx+-3] > cb) 
		               if (image[posy+2][posx+-2] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else if (image[posy+-3][posx+1] < c_b) 
		      if (image[posy+-3][posx+0] < c_b)
		       if (image[posy+-3][posx+-1] < c_b)
		        if (image[posy+-2][posx+-2] < c_b)
		         if (image[posy+-1][posx+-3] < c_b)
		          if (image[posy+0][posx+-3] < c_b)
		           if (image[posy+1][posx+-3] < c_b)
		            if (image[posy+2][posx+-2] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     if (image[posy+0][posx+3] > cb) 
		      if (image[posy+-1][posx+3] > cb) 
		       if (image[posy+-2][posx+2] > cb) 
		        if (image[posy+-3][posx+1] > cb) 
		         if (image[posy+-3][posx+0] > cb) 
		          if (image[posy+-3][posx+-1] > cb) 
		           if (image[posy+-2][posx+-2] > cb) 
		            if (image[posy+-1][posx+-3] > cb) 
		             if (image[posy+0][posx+-3] > cb) 
		              if (image[posy+1][posx+-3] > cb) 
		               if (image[posy+2][posx+-2] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		   else if (image[posy+1][posx+3] < c_b) 
		    if (image[posy+0][posx+3] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-1][posx+3] > cb) 
		       if (image[posy+-2][posx+2] > cb) 
		        if (image[posy+-3][posx+1] > cb) 
		         if (image[posy+-3][posx+-1] > cb) 
		          if (image[posy+-2][posx+-2] > cb) 
		           if (image[posy+-1][posx+-3] > cb) 
		            if (image[posy+0][posx+-3] > cb) 
		             if (image[posy+1][posx+-3] > cb) 
		              if (image[posy+2][posx+-2] > cb) 
		               if (image[posy+3][posx+-1] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else if (image[posy+-3][posx+0] < c_b) 
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else if (image[posy+0][posx+3] < c_b) 
		     if (image[posy+-1][posx+3] < c_b)
		      if (image[posy+-2][posx+2] < c_b)
		       if (image[posy+-3][posx+1] < c_b)
		        if (image[posy+-3][posx+0] < c_b)
		         if (image[posy+-3][posx+-1] < c_b)
		          if (image[posy+-2][posx+-2] < c_b)
		           if (image[posy+-1][posx+-3] < c_b)
		            return true;
		           else
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		          else
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		         else
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		        else
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		       else
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		      else
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		     else
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		    else
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		   else
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+0][posx+3] > cb) 
		      if (image[posy+-1][posx+3] > cb) 
		       if (image[posy+-2][posx+2] > cb) 
		        if (image[posy+-3][posx+0] > cb) 
		         if (image[posy+-3][posx+-1] > cb) 
		          if (image[posy+-2][posx+-2] > cb) 
		           if (image[posy+-1][posx+-3] > cb) 
		            if (image[posy+0][posx+-3] > cb) 
		             if (image[posy+1][posx+-3] > cb) 
		              if (image[posy+2][posx+-2] > cb) 
		               if (image[posy+3][posx+-1] > cb) 
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else if (image[posy+-3][posx+1] < c_b) 
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		  else
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+0][posx+3] > cb) 
		     if (image[posy+-1][posx+3] > cb) 
		      if (image[posy+-3][posx+1] > cb) 
		       if (image[posy+-3][posx+0] > cb) 
		        if (image[posy+-3][posx+-1] > cb) 
		         if (image[posy+-2][posx+-2] > cb) 
		          if (image[posy+-1][posx+-3] > cb) 
		           if (image[posy+0][posx+-3] > cb) 
		            if (image[posy+1][posx+-3] > cb) 
		             if (image[posy+2][posx+-2] > cb) 
		              if (image[posy+1][posx+3] > cb) 
		               return true;
		              else
		               if (image[posy+3][posx+-1] > cb) 
		                return true;
		               else
		                return false;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else if (image[posy+-2][posx+2] < c_b) 
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               if (image[posy+-1][posx+3] < c_b)
		                return true;
		               else
		                return false;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		 else
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+0][posx+3] > cb) 
		    if (image[posy+-2][posx+2] > cb) 
		     if (image[posy+-3][posx+1] > cb) 
		      if (image[posy+-3][posx+0] > cb) 
		       if (image[posy+-3][posx+-1] > cb) 
		        if (image[posy+-2][posx+-2] > cb) 
		         if (image[posy+-1][posx+-3] > cb) 
		          if (image[posy+0][posx+-3] > cb) 
		           if (image[posy+1][posx+-3] > cb) 
		            if (image[posy+1][posx+3] > cb) 
		             if (image[posy+2][posx+2] > cb) 
		              return true;
		             else
		              if (image[posy+2][posx+-2] > cb) 
		               return true;
		              else
		               return false;
		            else
		             if (image[posy+2][posx+-2] > cb) 
		              if (image[posy+3][posx+-1] > cb) 
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else if (image[posy+-1][posx+3] < c_b) 
		   if (image[posy+-2][posx+2] < c_b)
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+-3] < c_b)
		           if (image[posy+2][posx+-2] < c_b)
		            if (image[posy+3][posx+-1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		           else
		            if (image[posy+2][posx+2] < c_b)
		             if (image[posy+1][posx+3] < c_b)
		              if (image[posy+0][posx+3] < c_b)
		               return true;
		              else
		               return false;
		             else
		              return false;
		            else
		             return false;
		          else
		           return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		else
		 if (image[posy+0][posx+3] > cb) 
		  if (image[posy+-1][posx+3] > cb) 
		   if (image[posy+-2][posx+2] > cb) 
		    if (image[posy+-3][posx+1] > cb) 
		     if (image[posy+-3][posx+0] > cb) 
		      if (image[posy+-3][posx+-1] > cb) 
		       if (image[posy+-2][posx+-2] > cb) 
		        if (image[posy+-1][posx+-3] > cb) 
		         if (image[posy+0][posx+-3] > cb) 
		          if (image[posy+1][posx+3] > cb) 
		           if (image[posy+2][posx+2] > cb) 
		            if (image[posy+3][posx+1] > cb) 
		             return true;
		            else
		             if (image[posy+1][posx+-3] > cb) 
		              return true;
		             else
		              return false;
		           else
		            if (image[posy+1][posx+-3] > cb) 
		             if (image[posy+2][posx+-2] > cb) 
		              return true;
		             else
		              return false;
		            else
		             return false;
		          else
		           if (image[posy+1][posx+-3] > cb) 
		            if (image[posy+2][posx+-2] > cb) 
		             if (image[posy+3][posx+-1] > cb) 
		              return true;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		 else if (image[posy+0][posx+3] < c_b) 
		  if (image[posy+-1][posx+3] < c_b)
		   if (image[posy+-2][posx+2] < c_b)
		    if (image[posy+-3][posx+1] < c_b)
		     if (image[posy+-3][posx+0] < c_b)
		      if (image[posy+-3][posx+-1] < c_b)
		       if (image[posy+-2][posx+-2] < c_b)
		        if (image[posy+-1][posx+-3] < c_b)
		         if (image[posy+0][posx+-3] < c_b)
		          if (image[posy+1][posx+3] < c_b)
		           if (image[posy+2][posx+2] < c_b)
		            if (image[posy+3][posx+1] < c_b)
		             return true;
		            else
		             if (image[posy+1][posx+-3] < c_b)
		              return true;
		             else
		              return false;
		           else
		            if (image[posy+1][posx+-3] < c_b)
		             if (image[posy+2][posx+-2] < c_b)
		              return true;
		             else
		              return false;
		            else
		             return false;
		          else
		           if (image[posy+1][posx+-3] < c_b)
		            if (image[posy+2][posx+-2] < c_b)
		             if (image[posy+3][posx+-1] < c_b)
		              return true;
		             else
		              return false;
		            else
		             return false;
		           else
		            return false;
		         else
		          return false;
		        else
		         return false;
		       else
		        return false;
		      else
		       return false;
		     else
		      return false;
		    else
		     return false;
		   else
		    return false;
		  else
		   return false;
		 else
		  return false;
	}
	
	
	private static List<FeaturePoint> nonMaxSuppression(int w, int h, List<FeaturePoint> features)
	{
		int[][] pixels = new int[h][w];
		List<FeaturePoint> nonMaxFeatures = new ArrayList<FeaturePoint>();
		for (int i = 0; i < features.size(); ++i) {
			FeaturePoint fp = features.get(i);
			pixels[fp.y()][fp.x()] = fp.score();
		}
		for (int i = 0; i < features.size(); ++i) {
			FeaturePoint fp = features.get(i);
			int y = fp.y();
			int x = fp.x();
			int score = fp.score();
			if (score >= pixels[y-1][x+1] && score >= pixels[y-1][x] &&
			    score >= pixels[y-1][x-1] && score >= pixels[y][x+1] && 
			    score >= pixels[y][x-1] && score >= pixels[y+1][x+1] && 
			    score >= pixels[y+1][x] && score >= pixels[y+1][x-1]) {
				nonMaxFeatures.add(fp);
			}
		}
		return nonMaxFeatures;
        }

    public static List<FeaturePoint> getFeature(BufferedImage img)
    {
        List<FeaturePoint> feat1=null;
        try
	{
            int w = img.getWidth();
            int h = img.getHeight();
            int pixels[][] = new int[h][w];
		
            for (int y = 0; y < h; ++y) 
            {
		for (int x = 0; x < w; ++x) 
                {
                    pixels[y][x] = img.getRGB(x, y) & 0xFF;
		}
            }
            
            feat1 = detectWithNonMax(pixels, w, h, 30, 30);
            
            List<FeaturePoint> f2 = detect(pixels, w, h, 30, -1);
            
           /* System.out.println(feat1.size()+" : "+f2.size());
            
            Graphics2D g2 = img.createGraphics();
		g2.setColor(new Color(250, 0 ,0));
		int count = f2.size();
		for (int i = 0; i < count; ++i) {
			FeaturePoint p = f2.get(i);
                        System.out.println(p.score());
			g2.drawRect(p.x(), p.y(), 1, 1);
                }   
                
                ImageIO.write(img, "jpg", new File("out.jpg"));*/
	}
	catch(Exception e)
	{
            e.printStackTrace();
	}
        return feat1;
    }
    
    public static void main(String ar[])
    {
        try
        {
            File fe=new File("imagedb");
            File lt[]=fe.listFiles();      
            System.out.println(lt[0].getName());
            BufferedImage bi1=ImageIO.read(lt[0]);
            //getFeature(bi1);
            List<FeaturePoint> ob1=getFeature(bi1);
                    String ofeat="";
                    for(int i=0;i<ob1.size();i++)
                    {
                        FeaturePoint fp=ob1.get(i);
                        ofeat=ofeat+fp.x()+"@"+fp.y()+"@"+fp.score()+"#";
                        
                    }
                    System.out.println(ofeat);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
